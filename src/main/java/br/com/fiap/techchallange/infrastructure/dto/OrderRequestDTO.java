package br.com.fiap.techchallange.infrastructure.dto;

import java.util.List;

public record OrderRequestDTO(String id, List<ItemRequestDTO> items) {
}
