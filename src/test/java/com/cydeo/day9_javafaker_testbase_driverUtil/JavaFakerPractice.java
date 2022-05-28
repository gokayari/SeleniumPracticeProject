package com.cydeo.day9_javafaker_testbase_driverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {

    @Test
    public void test1() {
        //Creating Faker object to reach methods
        Faker faker = new Faker();

        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());

        System.out.println("faker.name().fullName() = " + faker.name().fullName());

        String randomNumber = faker.numerify("###-###-####");
        System.out.println("randomNumber = " + randomNumber);

        System.out.println("faker.numerify(\"+49###-###-##-##\") = " + faker.numerify("+49###-###-##-##"));

        String randomLetter = faker.letterify("???-???");
        System.out.println("randomLetter = " + randomLetter);

        String randomBoth = faker.bothify("?#?#?-?##??###?");
        System.out.println("randomBoth = " + randomBoth);


        System.out.println("faker.finance().creditCard() = "
                + faker.finance().creditCard().replaceAll("-", ""));

        System.out.println("faker.chuckNorris().fact() = "
                + faker.chuckNorris().fact().replaceAll("Chuck Norris", "Muhtar"));

    }
}