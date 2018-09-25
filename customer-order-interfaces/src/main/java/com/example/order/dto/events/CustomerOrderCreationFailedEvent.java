package com.example.order.dto.events;

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
public class CustomerOrderCreationFailedEvent extends ExceptionEvent{
	public CustomerOrderCreationRequestDTO customerOrderDTO;
	private static String EVENT_NAME = "CustomerOrderCreationFailedEvent";
	
	public CustomerOrderCreationFailedEvent(CustomerOrderCreationRequestDTO req, String errorMsg) {
		super(EVENT_NAME, errorMsg);
		this.customerOrderDTO = req;
		this.addHeader("eventName", getEventName());
		this.addHeader("busName", customerOrderDTO.getBusName());
		this.addHeader("locnNbr", customerOrderDTO.getLocnNbr());
		this.addHeader("OrderNbr", customerOrderDTO.getOrderNbr());
		this.addHeader("company", customerOrderDTO.getCompany());
		this.addHeader("division", customerOrderDTO.getDivision());
		this.addHeader("busUnit", customerOrderDTO.getBusUnit());
	}

}
