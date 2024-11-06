package application;

public class Program {

    public static void main(String[] args) {
        // you can test your classes here:
        StandardSensor ten = new StandardSensor(10);
        StandardSensor minusFive = new StandardSensor(-5);

        System.out.println(ten.read());
        System.out.println(minusFive.read());

        System.out.println(ten.isOn());
        ten.setOff();
        System.out.println(ten.isOn());

        TemperatureSensor s1 = new TemperatureSensor();
        TemperatureSensor s2 = new TemperatureSensor();
        TemperatureSensor s3 = new TemperatureSensor();
        s1.setOn();
        System.out.println(s1.read());

        System.out.println("Average sensor test:");

        AverageSensor averageSensor = new AverageSensor();
        averageSensor.addSensor(s1);
        averageSensor.addSensor(s2);
        averageSensor.addSensor(s3);
        averageSensor.setOn();
        System.out.println("s1 temperature: " + s1.read());
        System.out.println("s2 temperature: " + s2.read());
        System.out.println("s3 temperature: " + s3.read());

        System.out.println("Average temperature: " + averageSensor.read());
        // Isvestos temperaturos atskiru sensor vidurkis skiriasi,
        // nes averageSensor.read() methodas is naujo iskviecia
        // s1,s2,s3 objektu methodus su naujomis
        // Math.random reiksmemis.

        System.out.println("Average temperature: " + averageSensor.read());
        System.out.println("Average temperature: " + averageSensor.read());
        System.out.println("Average temperature: " + averageSensor.read());

        System.out.println("List of temperature readings: " + averageSensor.readings());
    }

}
