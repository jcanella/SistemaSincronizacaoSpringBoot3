package com.sistemaSincronizacao.stockexchange;

import java.time.Duration;

public class SyncMessage {
    private Duration difference; // Diferença de tempo entre os relógios

    public SyncMessage(Duration difference) {
        this.difference = difference;
    }

    public Duration getDifference() {
        return difference;
    }

    public void setDifference(Duration difference) {
        this.difference = difference;
    }
}
