public class Main {
    public static void main(String[] args) throws InterruptedException {
        String greeting="WELCOME TO CSTAD";
        String message="Don't give up this opportunity, do your best first";
        String process="Downloading";
        int delay=200;
        Thread thread1=new Thread(){
            @Override
            public synchronized void run() {
                for(char c:greeting.toCharArray()){
                    try {
                        Thread.sleep(delay);
                        System.out.print(c);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println();
            }
        };
        Thread thread2=new Thread(){
            @Override
            public synchronized void run() {
                try {
                    for(int i=0;i<message.length();i++){
                        Thread.sleep(delay);
                        System.out.print("*");
                    }
                    System.out.println();
                    for(char c:message.toCharArray()){
                        Thread.sleep(delay);
                        System.out.print(c);
                    }
                    System.out.println();
                    for(int i=0;i<message.length();i++){
                        Thread.sleep(delay);
                        System.out.print("-");
                    }
                    System.out.println();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread thread3=new Thread(){
            @Override
            public synchronized void run() {
                try {
                    for(char c:process.toCharArray()){
                        Thread.sleep(delay);
                        System.out.print(c);
                     }
                    for(int i=0;i<process.length();i++){
                        Thread.sleep(delay);
                        System.out.print(".");
                    }
                    System.out.println("Complete 100%");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println();
            }
        };
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
    }
}