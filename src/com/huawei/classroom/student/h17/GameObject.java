package com.huawei.classroom.student.h17;

public class GameObject {
    protected Player player;
    protected int x, y;
    protected int health;
    protected int range;
    protected int strength;
    protected String type;

    public GameObject(Player player, int x, int y) {
        this.player = player;
        this.x = x;
        this.y = y;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealth() {
        return this.health;
    }

    public boolean isDestroyed() {
        return this.health <= 0;
    }

    public void getHurt(int attack) {
        if(this.health - attack >= 0) this.health -= attack;
        else this.health = 0;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void attack(GameObject obj) {
        if(obj.isDestroyed() || this.isDestroyed() || this.strength <= 0) return;
        if(Utils.getDistance(this, obj) <= this.range) {
            obj.getHurt(this.strength);
        }
    }

    public void attack() {
        if(this.strength <= 0 || this.isDestroyed()) return;
        double min = this.range;
        int idx = -1;
        for(int i = 0; i < BattleField.gamesObjects.size(); i++) {
            GameObject obj = BattleField.gamesObjects.get(i);
            if(obj.isDestroyed() || obj.player == this.player) {
                continue;
            }
            if(Utils.getDistance(obj, this) <= min) {
                min = Utils.getDistance(obj, this);
                idx = i;
            }
        }
        if(idx >= 0) {
            String line = this.debug() + " 攻击 " + BattleField.gamesObjects.get(idx).debug();
            attack(BattleField.gamesObjects.get(idx));
            line += " 攻击后 health=" + BattleField.gamesObjects.get(idx).getHealth();
            BattleField.results.add(line);
        }
    }

    public String debug() {
        return "[" + this.player.getName() + "." + this.type + " live=" + !this.isDestroyed() + " x=" + this.x + " y=" + this.y + " health=" + this.health + "]";
    }
}
