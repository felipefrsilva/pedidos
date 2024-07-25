workspace {

    model {

        customer         = person "Cliente" "Cliente monta seu pedido" "External"

        group "Enterprise Tech Challange" {
            administrator    = person "Administrador" "Administrador do sistema" "Internal"
            counterAttendant = person "Atendente Balcão" "Atendente que interagem com o cliente" "Internal"
            kitchenAttendant = person "Atendente Cozinha" "Atendente responsável pela preparação do pedido" "Internal"
    
            orderManagement  = softwareSystem "Gerenciamento \nde \nPedidos" "Sistema responsável pela \ngestão de pedidos" "internal, systemPrincipal"{
                    ordermanager = container "Gerenciado \nde \nPedidos" "Aplicação \nde \ngestão dos Pedidos" "Spring Framework" "Application" {
                        group Adapters {
                            controller = component "Controller" "Componente responsável pela validação e formatação dos dados de entradas"
                            presenter  = component "Presenter" "Componente responsável pela formatação dos dados de saída"
                            gateway    = component "Gateway" "Componente responsável pela comunicação com componentes externos" 
                        }

                        group core {
                            usecase = component "Use Case" "Componente responsável pela Lógica de Negócio"
                            entity = component "Entity" "Componente responsável pela Regra de Negócio"
                        }

                        group infrastructure {
                            framework = component "Frameworks" "Componente responsável por interagir com o ambiente externo"
                            drivers     = component "Drivers" "Componente responsável pelas configurações das tecnologias utilizadas"
                        }                                          
                    }

                    webApplicationCustomer  = container "Aplicação Web \nCliente" "Aplicação onde os clientes realizam os pedidos" "Html, CSS e Javascript" "Web"
                    webApplicationAttendant = container "Aplicação Web Atendentes" "Aplicação onde visualizam e gerenciam os pedidos" "Html, CSS e javascript" "Web"
                    webApplicationAdmin     = container "Aplicação Web Administrador" "Aplicação onde os administradores realizam manutenção" "Html, CSS e javascript" "Web"
                    orderBD = container "Banco de Dados de Pedidos" "Banco de dados dos Pedidos Gerados" "MySQL" "BD"
                    monitorHall = container "Monitor \nde \nVisualização" "Monitor de acompanhamento dos pedidos" "Spring Framework" "Web"
                   
            }
        }
        
        systemPayment    = softwareSystem "Mercado Pago" "Sistema responsável pelo processamento do pagamento" "External"


        #Relations Landscape
        customer -> systemPayment "Realizar Pagamento do Pedido"

        #Relations Context
        customer            -> orderManagement "Criar Pedido, Realizar Pagamento e acompanhar preparação" "" ""
        administrator      -> orderManagement "Gestão e administração do sistema" "" ""
        counterAttendant    -> orderManagement "Notificação de entrega do produto ao cliente" "" ""
        kitchenAttendant    -> orderManagement "Notificação de inicio e término da preparação do produto" "" ""
        orderManagement     -> systemPayment "Busca código de pagamento" ""
        systemPayment       -> orderManagement "Envia status do pagamento" ""

        #Relations Container        
        customer                -> webApplicationCustomer "Escolha dos pedidos e leitura do QR Code" ""
        kitchenAttendant        -> webApplicationAttendant "Notificação de inicio e término da preparação do produto" ""
        counterAttendant        -> webApplicationAttendant "Notificação de entrega do produto ao cliente" ""        
        webApplicationCustomer  -> ordermanager "Envio dos pedidos realizados pelo o cliente" "http/json"
        webApplicationAttendant -> ordermanager "Envia notificações de atendimento"
        ordermanager            -> monitorHall "Envia Atualização de Status do pedido" "http/json"       
        ordermanager            -> orderBD "Armazenamento e atualização dos pedidos" "http/json"
        ordermanager            -> systemPayment "Solicitação do QR Code" "http/json"
        systemPayment           -> ordermanager "Envio código de processamento do pagamento" "http/json"
        administrator           -> webApplicationAdmin "Gestão e administração do sistema" "" ""
        webApplicationAdmin     -> ordermanager "Comandos para administração" "" ""


        #Relations Component
        webApplicationCustomer  -> framework "Envio das ordens dos clientes e solicita QR CODE" "http/json"
        webApplicationAttendant -> framework "Envia notificações de atendimento" "http/json"
        systemPayment           -> framework "Envia código de processamento ""http/json"
        webApplicationAdmin     -> framework "Envia os comandos para gestão e administração do sistema"
        framework               -> controller "uses" ""
        controller              -> usecase "uses" "" ""
        presenter               -> framework "uses" ""
        usecase                 -> entity "uses" ""
        usecase                 -> presenter "uses" ""
        usecase                 -> gateway "uses" ""
        gateway                 -> drivers "uses" ""        
        drivers                 -> orderBD "CRUD" "TCP/IP"
        framework               -> systemPayment "Solicita código de leitura"
        framework               -> monitorHall "Envia Atualização de Status do pedido"  

        
        production = deploymentEnvironment "Produção" {
            
            webApplicationCustomerInstance = deploymentNode "Totem Atendimento Cliente"{
                deploymentNode "Sistema Operacional"{
                    containerInstance webApplicationCustomer
                }
            }

            webApplicationAttendantInstance = deploymentNode "Monitor de Atendimento"{
                deploymentNode "Sistema Operacional"{
                    containerInstance webApplicationAttendant
                }
            }     

            webApplicationMonitorInstance = deploymentNode "Monitor de Visualização"{
                deploymentNode "Sistema Operacional"{
                    containerInstance monitorHall
                }
            }

            mecadopago = deploymentNode "System External" {
                 applicationmercadopago = infrastructureNode "Mercado Pago"{
                    tags "Sistema de pagamento"
                 }          
            }

            dockerhub = deploymentNode "DockerHub Imagens"{
                registry = infrastructureNode "Registry images"                        
            }

            kubernetes = deploymentNode "Kubernetes"  {
                tags "Kubernetes - node"

                apiIngress = infrastructureNode "Ingress"{
                    description "Interface de entrada do Kubernetes"
                    tags "Kubernetes - ing"
                }

                apiEgress = infrastructureNode "Egress"{
                    description "Interface de saída do Kubernetes"
                    tags "Kubernetes - ing"
                }
                
                namespace = deploymentNode "Namespace: default" {
                    tags "Kubernetes - ns"

                    configMap = infrastructureNode "ConfigMap"{
                            tags "Kubernetes - cm"
                    }   

                    secrets = infrastructureNode "Secrets"{
                            tags "Kubernetes - secret"
                    }   

                    pv = infrastructureNode "Persistence Volume"{
                            tags "Kubernetes - pv"
                    }

                    pvc = infrastructureNode "Persistence Volume Claim"{
                            tags "Kubernetes - pvc"
                    }              

                    serviceAplication = infrastructureNode "Service Aplicação \nPedidos"{
                            description "Service DNS Aplication"
                            tags "Kubernetes - svc"
                    }

                    serviceBD = infrastructureNode "Service Banco de Dados \nPedidos"{
                            description "Service DNS Banco de Dados"
                            tags "Kubernetes - svc"
                    }

                    aplicationInstance1 = deploymentNode "Pod2: Gerenciador de Pedidos" "" "" "Kubernetes - pod" {                               
                        containerInstance ordermanager
                    }

                    aplicationInstance2 = deploymentNode "Pod1: Gerenciador de Pedidos" "" "" "Kubernetes - pod" {                               
                        containerInstance ordermanager
                    }
                    
                
                    instanceBD = deploymentNode "Pod: Banco de Dados MySQL" "" "" "Kubernetes - pod" {
                        containerInstance orderBD
                    }
                }
            }                            
        }              

                     
        apiIngress                      -> serviceAplication "Forwards requests to" "HTTPS"
        webApplicationCustomerInstance  -> apiIngress "Forwards requests to" "HTTPS/JSON"
        webApplicationAttendantInstance -> apiIngress "Forwards requests to" "HTTPS/JSON"        
        mecadopago                      -> apiIngress "Forwards requests to"
        namespace                       -> apiEgress "Forwards requests to"          
        serviceAplication               -> aplicationInstance1 "Forwards requests to" "HTTPS"
        serviceAplication               -> aplicationInstance2 "Forwards requests to" "HTTPS"
        aplicationInstance1             -> serviceBD "Forwards requests to" "TCP/IP"
        aplicationInstance2             -> serviceBD "Forwards requests to" "TCP/IP"
        serviceBD                       -> instanceBD "Forwards requests to" "HTTPS"
        apiEgress                       -> webApplicationMonitorInstance "Forwards requests to"
        apiEgress                       -> mecadopago "Forwards requests to"
        kubernetes                      -> dockerhub "Forwards requests to"        
        aplicationInstance1             -> secrets "Forwards requests to"        
        aplicationInstance2             -> secrets "Forwards requests to"
        instanceBD                      -> pv "Forwards requests to"
        instanceBD                      -> pvc "Forwards requests to"
        instanceBD                      -> configMap "Forwards requests to" 
    }

    views {

        systemContext orderManagement {
            include * systemPayment
        }

        container orderManagement {
            include *
        }

        component ordermanager {
            include *
        }       

        deployment orderManagement "production" "KubernetesDeployment" {
            include *
            exclude *->ordermanager ordermanager->*
            
        }

        styles {
            theme default

            # default overrides

            element "Software System" {
                shape RoundedBox
                background #1168bd
                color #ffffff
            }

            element "Person" {
                shape person
            }       

            element "External" {
                background #999999
                color #ffffff
            }

            element "Internal" {                
                background #08427b
                color #ffffff
            }

            element "BD" {
                shape Cylinder
            }

            element "Web" {
                shape WebBrowser
            }

            element "Application" {
                shape Hexagon
            }

            element "Component" {
                shape component
            }

            element "Group" {
                stroke #08427b
                fontSize 30
                StrokeWidth 5
            }

            element "systemPrincipal" {
                fontSize 30
            }           
        }

        theme https://static.structurizr.com/themes/amazon-web-services-2020.04.30/theme.json 
        theme https://static.structurizr.com/themes/kubernetes-v0.3/theme.json

    }

}