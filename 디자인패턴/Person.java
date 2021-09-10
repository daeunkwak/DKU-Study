/*
프로그램은 요건은 다음과 같습니다.

남자와 여자가 결혼을 하여 자식을 가지는 프로그램을 작성하고자 한다.
남자와 여자는 이름과 나이를 가지고 결혼을 할 수 있으며 애완동물을 가질 수 있다.

여자는 출산을 할 수 있다. 출산 자녀의 성별은 랜덤으로 주어진다.
두 사람의 혼인 관계를 확인 할 수 있는 방법을 가져야한다.
두 사람의 자식 부모관계를 확인 할 수 있으며 자식 관계인 경우 아들인지 딸인지, 아빠인지 엄마인지를
구분하는 방법을 가져야 한다.
애완 동물은 개와 고양이 두 종류이고 개는 '멍멍'하고 소리를 내며 고양이는 '야옹'하고 소리를 낸다.

위 요건을 만족하는 프로그램을 작성하고 다음 흐름을 프로그램으로 작성하시오
남자와 여자를 생성하고 결혼을 시킨 후 출산을 2번 한다.
가족 집단을 크기 가변형 collection으로 표현한다.
아빠와 자녀의 관계가 아들인지 딸인지를 출력한다.
첫번째 자녀는 개를 애완동물로 가지며 두번째 자녀는 고양이를 애완 동물로 가진다.
가족 전체의 애완동물이 어떤 소리를 내는 지 출력한다.

충족해야할 기술
1. 상속이 이용되어야 한다.
2. 다형성이 이용되어야 한다.
3. 자바의 collection 구조가 이용되어야 한다 -> 가족집단에 사용
 */


// 32200185 곽다은

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class Person {
    // family로 가족을 묶어주기 -> hashmap의 key값을 이용해 역할을 알 수 있도록함
    HashMap<String, Person> family = new HashMap<String, Person>();
    String name;
    int age;
    Pet pet = null;
    boolean isMarried = false;

    // 매개변수로 결혼한 사람 객체 넣기
    void getMarried(Person p){
        isMarried = true;
        System.out.println(name + ", " + p.name + "은 결혼했습니다.");

        if(this instanceof Man){
            family.put("아빠", this);
            family.put("엄마", p);
            p.family.put("아빠", this);
            p.family.put("엄마", p);
        }
        else{
            family.put("엄마",this);
            family.put("아빠",p);
            p.family.put("엄마",this);
            p.family.put("아빠",p);
        }
    }

    void getPet(Pet p){
        pet = p;
        // System.out.println(p.petType + "를 분양받았습니다.");
    }
}


class Man extends Person{
    Man(){}
    Man(String name, int age){
        this.name = name;
        this.age = age;
    }
}

class Woman extends Person{
    Woman(){}
    Woman(String name, int age){
        this.name = name;
        this.age = age;
    }

    // 첫째, 둘째를 구분하기 위한 변수 numm
    int numm = 0;

    void giveBirth(){
        int sex;
        Random r = new Random();
        sex = r.nextInt(2);  // sex는 0 or 1
        numm += 1;

        if (sex == 0){
            Man son = new Man();
            son.name = "아들";
            // System.out.println("아들을 출산하였습니다.");
            if (numm == 1){
                // 가족객체에 아들을 추가함
                this.family.put("첫째", son);
                this.family.get("아빠").family.put("첫째", son);
                son.family.put("엄마", this);
                son.family.put("아빠", this.family.get("아빠"));

                // 첫째 -> 강아지 분양
                Dog dog = new Dog();
                son.getPet(dog);
            }
            else{
                this.family.put("둘째", son);
                this.family.get("아빠").family.put("둘째", son);
                son.family.put("엄마", this);
                son.family.put("아빠", this.family.get("아빠"));

                // 둘째 -> 고양이 분양
                Cat cat = new Cat();
                son.getPet(cat);
            }
        }
        else{
            Woman daughter = new Woman();
            daughter.name = "딸";
            // System.out.println("딸을 출산하였습니다.");
            if (numm == 1){
                // 가족객체에 딸을 추가함
                this.family.put("첫째", daughter);
                this.family.get("아빠").family.put("첫째", daughter);
                daughter.family.put("엄마", this);
                daughter.family.put("아빠", this.family.get("아빠"));
                // 첫째 -> 강아지 분양
                Dog dog = new Dog();
                daughter.getPet(dog);
            }
            else{
                this.family.put("둘째", daughter);
                this.family.get("아빠").family.put("둘째", daughter);
                daughter.family.put("엄마", this);
                daughter.family.put("아빠", this.family.get("아빠"));
                // 둘째 -> 고양이 분양
                Cat cat = new Cat();
                daughter.getPet(cat);
            }
        }
    }
}

// 추상클래스 Pet -> Dog, Cat클래스 구현
abstract class Pet{
    String petType;
    abstract void cry();
}

class Dog extends Pet{
    Dog(){
        petType = "강아지";
    }
    @Override
    void cry() {
        System.out.println("멍멍");
    }
}

class Cat extends Pet{
    Cat(){
        petType = "고양이";
    }
    @Override
    void cry() {
        System.out.println("야옹");
    }
}

class Test{
    public static void main(String[] args) {
        // 1. 남자와 여자 생성
        Man m1 = new Man("박지원", 22);
        Woman w1 = new Woman("곽채영", 22);

        // 2. 결혼시키기
        m1.getMarried(w1);

        // 3. 출산 2번
        w1.giveBirth();
        w1.giveBirth();

        // 4. 자녀 관계 (아들 or 딸) 출력
        Iterator<String> keys = m1.family.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            System.out.println(String.format("%s : %s", key, m1.family.get(key).name));
        }

        // m1의 자녀들 불러와서 c1, c2객체 생성
        Person c1 = m1.family.get("첫째");
        Person c2 = m1.family.get("둘째");

        // 5. 가족의 애완동물 울음소리 출력
        c1.pet.cry();
        c2.pet.cry();
    }
}




