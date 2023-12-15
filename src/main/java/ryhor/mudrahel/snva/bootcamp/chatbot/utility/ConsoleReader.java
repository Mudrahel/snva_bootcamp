package ryhor.mudrahel.snva.bootcamp.chatbot.utility;

public interface ConsoleReader {

    public int readInt() throws Exception;
    public String readString();
    public String readLine();
    public void close();
}
