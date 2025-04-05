package com.joy.bi.dashboard.repository;

import com.joy.bi.dashboard.model.RevenueStatsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RevenueStatsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<RevenueStatsDto> getQuarterlyRevenueStats() {
        String sql = """
            SELECT 
                YEAR(ct.TransactionDate) AS year,
                DATEPART(QUARTER, ct.TransactionDate) AS quarter,
                SUM(ct.TransactionAmount) AS revenue,
                COUNT(o.OrderID) AS orders,
                ROUND(SUM(ct.TransactionAmount) * 1.0 / NULLIF(COUNT(o.OrderID), 0), 2) AS avgOrderValue
            FROM Sales.CustomerTransactions ct
            JOIN Sales.Orders o ON ct.CustomerID = o.CustomerID
            WHERE ct.IsFinalized = 1 
              AND ct.TransactionAmount > 0
              AND ct.TransactionDate >= DATEADD(YEAR, -13, GETDATE())
            GROUP BY YEAR(ct.TransactionDate), DATEPART(QUARTER, ct.TransactionDate)
            ORDER BY year DESC, quarter DESC;
        """;

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            RevenueStatsDto dto = new RevenueStatsDto();
            dto.setYear(rs.getInt("year"));
            dto.setQuarter(rs.getInt("quarter"));
            dto.setRevenue(rs.getDouble("revenue"));
            dto.setOrders(rs.getInt("orders"));
            dto.setAvgOrderValue(rs.getDouble("avgOrderValue"));
            return dto;
        });
    }
    public List<RevenueStatsDto> getQuarterlyRevenueStats(int startYear, int endYear) {
        String sql = """
        SELECT 
            YEAR(ct.TransactionDate) AS year,
            DATEPART(QUARTER, ct.TransactionDate) AS quarter,
            SUM(ct.TransactionAmount) AS revenue,
            COUNT(o.OrderID) AS orders,
            ROUND(SUM(ct.TransactionAmount) * 1.0 / NULLIF(COUNT(o.OrderID), 0), 2) AS avgOrderValue
        FROM Sales.CustomerTransactions ct
        JOIN Sales.Orders o ON ct.CustomerID = o.CustomerID
        WHERE ct.IsFinalized = 1 
          AND ct.TransactionAmount > 0
          AND YEAR(ct.TransactionDate) BETWEEN ? AND ?
        GROUP BY YEAR(ct.TransactionDate), DATEPART(QUARTER, ct.TransactionDate)
        ORDER BY year DESC, quarter DESC;
    """;

        return jdbcTemplate.query(sql, new Object[]{startYear, endYear}, (rs, rowNum) -> {
            RevenueStatsDto dto = new RevenueStatsDto();
            dto.setYear(rs.getInt("year"));
            dto.setQuarter(rs.getInt("quarter"));
            dto.setRevenue(rs.getDouble("revenue"));
            dto.setOrders(rs.getInt("orders"));
            dto.setAvgOrderValue(rs.getDouble("avgOrderValue"));
            return dto;
        });
    }

}

