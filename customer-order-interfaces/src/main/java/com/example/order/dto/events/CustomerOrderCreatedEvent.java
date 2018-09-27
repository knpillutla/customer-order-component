package com.example.order.dto.events;

import java.util.Map;

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
@NoArgsConstructor
@Data
public class CustomerOrderCreatedEvent extends BaseEvent {
	private CustomerOrderDTO customerOrderDTO;
	private static String EVENT_NAME = "CustomerOrderCreatedEvent";
	public CustomerOrderCreatedEvent(CustomerOrderDTO customerOrderDTO) {
		this(customerOrderDTO, null);
	}

	public CustomerOrderCreatedEvent(CustomerOrderDTO customerOrderDTO, Map headerMap) {
		super(EVENT_NAME);
		this.customerOrderDTO = customerOrderDTO;
		if(headerMap != null)
			this.setHeaderMap(headerMap);
		this.addHeader("eventName", getEventName());
		this.addHeader("busName", this.customerOrderDTO.getBusName());
		this.addHeader("locnNbr", this.customerOrderDTO.getLocnNbr());
		this.addHeader("OrderNbr", this.customerOrderDTO.getOrderNbr());
		this.addHeader("company", this.customerOrderDTO.getCompany());
		this.addHeader("division", this.customerOrderDTO.getDivision());
		this.addHeader("busUnit", this.customerOrderDTO.getBusUnit());
	}
}
