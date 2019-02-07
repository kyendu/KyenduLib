package kyendulib.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import kyendulib.enums.EntityType;

public abstract class Entity {

	protected int width;
	protected int height;
	
	protected int x;
	protected int y;
	protected float velX = 0;
	protected float velY = 0;
	
	protected int health;
	
	protected EntityType type;
	
	public Entity(int x, int y, EntityType type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public EntityType getType() {
		return type;
	}

	public void setType(EntityType type) {
		this.type = type;
	}
	
}