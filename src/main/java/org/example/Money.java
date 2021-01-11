package org.example;

public class Money implements Expression {

    protected int amount;
    protected final String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public String currency() {
        return currency;
    };

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public Money times(int multiplier) {
        return new Money(amount * multiplier, this.currency);
    }

    @Override
    public Money reduce(String to) {
        return this;
    }

    public Expression plus(Money addend) {
        return new Sum(this, addend);
    }

    public boolean equals(Object object) {
        Money that = (Money) object;
        return amount == that.amount
                && this.currency == that.currency();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Money{");
        sb.append("amount=").append(amount);
        sb.append(", currency='").append(currency).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
