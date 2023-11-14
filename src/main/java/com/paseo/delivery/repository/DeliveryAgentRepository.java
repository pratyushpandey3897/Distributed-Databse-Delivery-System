package com.paseo.delivery.repository;

import com.paseo.delivery.model.DeliveryAgent;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DeliveryAgentRepository {
    private NamedParameterJdbcTemplate template;

    public DeliveryAgentRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public void updateDeliveryAgentOrderId(String orderId) {
        String query = "UPDATE delivery_agents SET orderId=:orderId WHERE orderId IS NULL LIMIT 1";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("orderId", orderId);
        template.update(query, params);
    }

    public void createDeliveryAgent(DeliveryAgent deliveryAgent) {
        String query = "INSERT INTO delivery_agents(agentId, agentName, orderId, zipCode) VALUES(:agentId, :agentName, :orderId, :zipCode)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("agentId", deliveryAgent.getAgentId());
        params.addValue("agentName", deliveryAgent.getAgentName());
        params.addValue("orderId", deliveryAgent.getOrderId());
        params.addValue("zipCode", deliveryAgent.getZipCode());
        template.update(query, params);
    }

    public void deleteDeliveryAgent(String agentId) {
        String query = "DELETE FROM delivery_agents WHERE agentId=:agentId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("agentId", agentId);
        template.update(query, params);
    }

    public void updateDeliveryAgent(DeliveryAgent deliveryAgent) {
        String query = "UPDATE delivery_agents SET agentName=:agentName, orderId=:orderId, zipCode=:zipCode WHERE agentId=:agentId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("agentId", deliveryAgent.getAgentId());
        params.addValue("agentName", deliveryAgent.getAgentName());
        params.addValue("orderId", deliveryAgent.getOrderId());
        params.addValue("zipCode", deliveryAgent.getZipCode());
        template.update(query, params);
    }
}
