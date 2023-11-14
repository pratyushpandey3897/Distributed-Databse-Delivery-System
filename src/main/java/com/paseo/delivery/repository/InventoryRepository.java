package com.paseo.delivery.repository;

import com.paseo.delivery.model.Inventory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryRepository {
    private NamedParameterJdbcTemplate template;

    public InventoryRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public void updateInventory(String medicineId, String orderId, int n) {
        String query = "UPDATE inventory SET orderId=:orderId WHERE medicineId=:medicineId LIMIT :limit";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("orderId", orderId);
        params.addValue("medicineId", medicineId);
        params.addValue("limit", n);
        template.update(query, params);
    }

    public int getInventoryCountByMedicineId(String medicineId) {
        String query = "SELECT COUNT(*) FROM inventory WHERE medicineId=:medicineId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("medicineId", medicineId);
        return template.queryForObject(query, params, Integer.class);
    }

    public void createInventory(Inventory inventory) {
        String query = "INSERT INTO inventory(uniqueId, warehouseId, orderId, medicineId, zipCode) VALUES(:uniqueId, :warehouseId, :orderId, :medicineId, :zipCode)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("uniqueId", inventory.getUniqueId());
        params.addValue("warehouseId", inventory.getWarehouseId());
        params.addValue("orderId", inventory.getOrderId());
        params.addValue("medicineId", inventory.getMedicineId());
        params.addValue("zipCode", inventory.getZipCode());
        template.update(query, params);
    }

    public void deleteInventory(String uniqueId) {
        String query = "DELETE FROM inventory WHERE uniqueId=:uniqueId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("uniqueId", uniqueId);
        template.update(query, params);
    }

    public void updateInventory(Inventory inventory) {
        String query = "UPDATE inventory SET warehouseId=:warehouseId, orderId=:orderId, medicineId=:medicineId, zipCode=:zipCode WHERE uniqueId=:uniqueId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("uniqueId", inventory.getUniqueId());
        params.addValue("warehouseId", inventory.getWarehouseId());
        params.addValue("orderId", inventory.getOrderId());
        params.addValue("medicineId", inventory.getMedicineId());
        params.addValue("zipCode", inventory.getZipCode());
        template.update(query, params);
    }
}
