package com.example.order.dto.events;

import java.util.Map;

import com.example.order.dto.requests.CustomerOrderCreationRequestDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@NoArgsConstructor
@Data
public class CustomerOrderDownloadEvent extends BaseEvent {
	private CustomerOrderCreationRequestDTO orderCreationRequestDTO;
	private static String EVENT_NAME = "OrderDownloadEvent";
	public CustomerOrderDownloadEvent(CustomerOrderCreationRequestDTO orderReqDTO) {
		this(orderReqDTO, null);
	}

	public CustomerOrderDownloadEvent(CustomerOrderCreationRequestDTO orderReqDTO, Map headerMap) {
		super(EVENT_NAME);
		this.orderCreationRequestDTO = orderReqDTO;
		if(headerMap != null)
			this.setHeaderMap(headerMap);
		this.addHeader("eventName", getEventName());
		this.addHeader("busName", orderCreationRequestDTO.getBusName());
		this.addHeader("locnNbr", orderCreationRequestDTO.getLocnNbr());
		this.addHeader("OrderNbr", orderCreationRequestDTO.getOrderNbr());
		this.addHeader("company", orderCreationRequestDTO.getCompany());
		this.addHeader("division", orderCreationRequestDTO.getDivision());
		this.addHeader("busUnit", orderCreationRequestDTO.getBusUnit());
	}
}
