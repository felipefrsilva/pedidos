package br.com.fiap.techchallange.infrastructure.service.mock;

public class SequentialNumberGenerator {
    private static SequentialNumberGenerator instance;
    private int currentNumber;

    private SequentialNumberGenerator() {
        currentNumber = 0;
    }

    public static synchronized SequentialNumberGenerator getInstance() {
        if (instance == null) {
            instance = new SequentialNumberGenerator();
        }
        return instance;
    }

    public synchronized Integer generateNextNumber() {
        if (currentNumber < 10000) {
            currentNumber++;
            return  currentNumber;
        } else {
            throw new IllegalStateException("Limite máximo de números atingido");
        }
    }

    public String getFormattedCurrentNumber(){
        return String.format("%05d", currentNumber);
    }

    public synchronized void reset() {
        currentNumber = 0;
    }
}
