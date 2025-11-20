package edu.ucsal.fiadopay.service;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class FraudAnalysisService {
	public boolean isFraud(BigDecimal amount, double limit) {
		if (amount == null)
			return false;

		boolean isSuspicious = amount.doubleValue() > limit;

		if (isSuspicious) {
			System.out.println("Provavel Fraude: Valor R$ " + amount + " excede o limite de R$ " + limit);
		}

		return isSuspicious;
	}
}
