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
	private CustomerOrderCreationRequestDTO customerOrderCreationRequestDTO;
	private static String EVENT_NAME = "CustomerOrderDownloadEvent";
	public CustomerOrderDownloadEvent(CustomerOrderCreationRequestDTO orderReqDTO) {
		this(orderReqDTO, null);
	}

	public CustomerOrderDownloadEvent(CustomerOrderCreationRequestDTO orderCreationRequestDTO, Map headerMap) {
		super(EVENT_NAME);
		this.customerOrderCreationRequestDTO = orderCreationRequestDTO;
		if(headerMap != null)
			this.setHeaderMap(headerMap);
		this.addHeader("eventName", getEventName());
		this.addHeader("busName", customerOrderCreationRequestDTO.getBusName());
		this.addHeader("locnNbr", customerOrderCreationRequestDTO.getLocnNbr());
		this.addHeader("OrderNbr", customerOrderCreationRequestDTO.getOrderNbr());
		this.addHeader("company", customerOrderCreationRequestDTO.getCompany());
		this.addHeader("division", customerOrderCreationRequestDTO.getDivision());
		this.addHeader("busUnit", customerOrderCreationRequestDTO.getBusUnit());
	}
}
