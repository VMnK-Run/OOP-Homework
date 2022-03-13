package com.huawei.classroom.student.h05;

public class Test {

    public Test() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // ĳһ����Ϸ������Ҫ��ɫ����:
        // Tank HeavyTank ����̹�� ��ʼ����ֵ200�������� 20
        // Medium Tank ����̹�� ��ʼ����ֵ100�������� 10
        // War Factory ������ ��ʼ����ֵ100���޹�����
        // Barrack ��Ӫ������ѵ������ǹ���� RPG������Ȯ,��ʼ����ֵ100���޹�����
        // Rifle soldier ��ǹ�� ��ʼ����ֵ50(��ս ��Ȯ����)�������� 5����ս��Ȯ����һ�λ��о�Ȯ)
        // Rocket soldier ����� ��ʼ����ֵ50(��ս ��Ȯ����)�������� 10
        // Dog ��Ȯ ,��ʼ����ֵ50��������5(��ս����ʱ��һ�ڱ���)
        // ���⻹Ҫ��ͨ��Soldier.getLivingSoldierCount/getDeadedSoldierCount
        // ͳ�������ж��ٸ����ŵĺ���ȥ��ʿ������
        // ����ѭ������Ϸ���򣬲��������²��Դ�����ƴ���
        // ��ҵ���ĵ�ʱ�򣬳������µ��õķ������⣬���������µĵ��÷��������ǿ����в�ͬ����Ϸ�ʽ
        // ������һ��Dog��������HeavyTank���ж�HeayTank.getHealth()
        // �κζ�����getHealth() ���������ص�ǰ����ֵ������Ѿ������򷵻� <=0��һ������
        Barrack barrack = new Barrack();
        if (barrack.getHealth() == 100) {
            System.out.println("ok1");
        }
        // tracing ѵ�����µ�ʿ�����߹�
        RifleSoldier rifleSoldier1 = (RifleSoldier) barrack.traing(EnumObjectType.rifleSoldier);
        if (rifleSoldier1.getHealth() == 50) {
            System.out.println("ok2");
        }
        RPGSoldier rPGSoldier1 = (RPGSoldier) barrack.traing(EnumObjectType.RPGSoldier);
        if (rPGSoldier1.getHealth() == 50) {
            System.out.println("ok3");
        }
        Dog dog1 = (Dog) barrack.traing(EnumObjectType.dog);
        if (dog1.getHealth() == 50) {
            System.out.println("ok4");
        }
        // �����µı�����
        WarFactory warFactory = new WarFactory();
        if (warFactory.getHealth() == 100) {
            System.out.println("ok5");
        }
        // building ��������ͺ�̹��
        Tank mediumTank1 = (MediumTank) warFactory.building(EnumObjectType.mediumTank);
        if (mediumTank1.getHealth() == 100) {
            System.out.println("ok6");
        }

        Tank heavyTank1 = (HeavyTank) warFactory.building(EnumObjectType.heavyTank);
        if (heavyTank1.getHealth() == 200) {
            System.out.println("ok7");
        }

        mediumTank1.attack(rifleSoldier1);
        // ��mediumTank1����һ�Σ�health-10
        if (rifleSoldier1.getHealth() == 40) {
            System.out.println("ok8");
        }

        dog1.attack(rifleSoldier1);
        // �� dog ����һ�Σ�health<=0
        if (rifleSoldier1.isDestroyed()) {
            System.out.println("ok9");
        }

        mediumTank1.attack(dog1);
        // �������� health-10
        if (dog1.getHealth() == 40) {
            System.out.println("ok10");
        }
        RifleSoldier rifleSoldier2 = (RifleSoldier) barrack.traing(EnumObjectType.rifleSoldier);
        // ��RifleSoldier���� һ������
        rifleSoldier2.attack(dog1);
        if (dog1.isDestroyed()) {
            System.out.println("ok11");
        }
        // Soldier ��ǰ���ŵ�����2��rifleSoldier2��rPGSoldier1��������������1��rifleSoldier1��
        if (Soldier.getLivingSoldierCount() == 2 && Soldier.getDeadedSoldierCount() == 1) {
            System.out.println("ok12");
        }

    }

}
