package ryhor.mudrahel.snva.bootcamp.chatbot.entity.payments;

public class Cash implements Payment{
    public String getType(){
        return "Cash";
    }

    @Override
    public String getPaymentData() {
        return "Pay cash in full";
    }
}
