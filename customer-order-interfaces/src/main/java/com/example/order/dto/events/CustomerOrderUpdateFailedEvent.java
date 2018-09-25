package com.example.order.dto.events;

import com.example.order.dto.requests.CustomerOrderUpdateRequestDTO;
import com.example.order.dto.responses.CustomerOrderDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
public class CustomerOrderUpdateFailedEvent extends ExceptionEvent{
	public CustomerOrderUpdateRequestDTO customerOrderUpdateRequestDTO;
	private static String EVENT_NAME = "CustomerOrderUpdateFailedEvent";
	public CustomerOrderUpdateFailedEvent(CustomerOrderUpdateRequestDTO req, String errorMsg) {
		super(EVENT_NAME, errorMsg);
		this.customerOrderUpdateRequestDTO = req;
		this.addHeader("eventName", getEventName());
		this.addHeader("busName", customerOrderUpdateRequestDTO.getBusName());
		this.addHeader("locnNbr", customerOrderUpdateRequestDTO.getLocnNbr());
		this.addHeader("OrderNbr", customerOrderUpdateRequestDTO.getOrderNbr());
		this.addHeader("company", customerOrderUpdateRequestDTO.getCompany());
		this.addHeader("division", customerOrderUpdateRequestDTO.getDivision());
		this.addHeader("busUnit", customerOrderUpdateRequestDTO.getBusUnit());
	}

}
