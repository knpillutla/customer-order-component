package com.example.order.dto.events;

import com.example.order.dto.requests.CustomerOrderLineStatusUpdateRequestDTO;
import com.example.order.dto.responses.CustomerOrderDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@NoArgsConstructor
@Data
public class CustomerOrderLineAllocationFailedEvent extends ExceptionEvent{
	public CustomerOrderLineStatusUpdateRequestDTO orderLineStatusUpdateRequestDTO;
	private static String EVENT_NAME = "CustomerOrderLineAllocationFailedEvent";
	public CustomerOrderLineAllocationFailedEvent(CustomerOrderLineStatusUpdateRequestDTO req, String errorMsg) {
		super(EVENT_NAME, errorMsg);
		this.orderLineStatusUpdateRequestDTO = req;
		this.addHeader("eventName", getEventName());
		this.addHeader("busName", req.getBusName());
		this.addHeader("locnNbr", req.getLocnNbr());
		this.addHeader("OrderNbr", req.getOrderNbr());
		this.addHeader("company", req.getCompany());
		this.addHeader("division", req.getDivision());
		this.addHeader("busUnit", req.getBusUnit());
	}

}
