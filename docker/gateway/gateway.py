from flask import Flask, request

app = Flask(__name__)

@app.route('/')
def main_route():
    return "Gateway Service"


# https://www.mercadopago.com.br/developers/pt/reference/qr-dynamic/_instore_orders_qr_seller_collectors_user_id_pos_external_pos_id_qrs/post
@app.route('/qrs', methods=['POST'])
def generate_qr_code():
    return {
        "qr_data": "00020101021243650016COM.MERCADOLIBRE02013063638f1192a-5fd1-4180-a180-8bcae3556bc35204000053039865802BR5925IZABEL AAAA DE MELO6007BARUERI62070503***63040B6D",
        "in_store_order_id": "d4e8ca59-3e1d-4c03-b1f6-580e87c654ae"
    }

if __name__ == "__main__":
    app.run(debug=False, host="0.0.0.0")