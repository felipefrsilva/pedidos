package br.com.fiap.techchallange.core.usecase.dto.order;

import br.com.fiap.techchallange.core.entity.vo.Item;

import java.util.HashMap;
import java.util.List;

public record InputDataOrderDTO(String id, List<InputDataItemDTO> items) {}
