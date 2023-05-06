package app;

public class Runclassss extends Thread {

  public static void main(String[] args) {
    Motors motorsObj = new Motors();
    LineFollow LFObj = new LineFollow();
    Thread thread1 = new Thread(LFObj);
    Thread thread3 = new Thread(motorsObj);

    thread1.start();
    thread3.start();
  }
}