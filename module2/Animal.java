package ua.kpi_java_training5.alekseenko.src.module3;

/**
 * Author: Aleksey Alekseenko
 * Date: 12.06.13
 */
public abstract class Animal implements Moveable, Eatable {
    public Desert desert;
    public HurdleFactory hurdleFactory;
    public Position position;
    int moveStep;
    int age;
    boolean isDead;

    /**
     * Checks is equal current position of animal with hurdle position
     *
     * @param positionX
     * @param positionY
     * @return
     */
    public boolean isHurdle(int positionX, int positionY) {
        boolean hasHurdle = false;
        for (int i = 0; i < hurdleFactory.getQuantityOfHurdles(); i++) {
            if (hurdleFactory.getHurdle(i).position.getX() == positionX && hurdleFactory.getHurdle(i).position.getY() == positionY) {
                hasHurdle = true;
            }
        }
        return hasHurdle;
    }

    /**
     * Animal's move
     */
    public void move() {
        Direction direction = DirectionMove.selectDirection();

        switch (direction) {
            case LEFT:
                moveOnAxisX(direction);
                break;

            case RIGHT:
                moveOnAxisX(direction);
                break;

            case DOWN_LEFT:
                moveOnDiagonal(direction);
                break;

            case DOWN_RIGHT:
                moveOnDiagonal(direction);
                break;

            case UP_LEFT:
                moveOnDiagonal(direction);
                break;

            case UP_RIGHT:
                moveOnDiagonal(direction);
                break;
        }


    }

    /**
     * Animal's move on axis Y, with set direction
     *
     * @param direction set direction
     */
    public void moveOnAxisY(Direction direction) {
        if (direction.equals(Direction.UP_LEFT) || direction.equals(Direction.UP_RIGHT)) {
            if (this.position.getY() + moveStep <= desert.height && !isHurdle(this.position.getX(), this.position.getY() + moveStep)) {
                this.position.y += moveStep;
            } else {
                move();
            }
        } else if (direction.equals(Direction.DOWN_LEFT) || direction.equals(Direction.DOWN_RIGHT)) {
            if (this.position.y - moveStep >= 0 && !isHurdle(this.position.x, this.position.y - moveStep)) {
                this.position.y -= moveStep;
            } else {
                move();
            }
        }
    }

    /**
     * Animal's move in complete direction
     *
     * @param direction set direction
     */
    public void moveOnDiagonal(Direction direction) {
        if (this.position.y % 2 == 0) {
            if (direction.equals(Direction.UP_LEFT)) {
                moveOnAxisY(direction);
            }
            if (direction.equals(Direction.UP_RIGHT)) {
                if (this.position.x + moveStep <= desert.length && this.position.y + moveStep <= desert.height
                        && !isHurdle(this.position.x + moveStep, this.position.y + moveStep)) {
                    this.position.x += moveStep;
                    this.position.y += moveStep;
                } else {
                    move();
                }
            }
            if (direction.equals(Direction.DOWN_LEFT)) {
                moveOnAxisY(direction);
            }
            if (direction.equals(Direction.DOWN_RIGHT)) {
                if (this.position.x + moveStep <= desert.length && this.position.y - moveStep >= 0
                        && !isHurdle(this.position.x + moveStep, this.position.y - moveStep)) {
                    this.position.x += moveStep;
                    this.position.y -= moveStep;
                } else {
                    move();
                }
            }
        } else {
            if (direction.equals(Direction.UP_LEFT)) {
                if (this.position.x - moveStep >= 0 && this.position.y + moveStep <= desert.height
                        && !isHurdle(this.position.x - moveStep, this.position.y + moveStep)) {
                    this.position.x -= moveStep;
                    this.position.y += moveStep;
                } else {
                    move();
                }
            }
            if (direction.equals(Direction.UP_RIGHT)) {
                moveOnAxisY(direction);
            }
            if (direction.equals(Direction.DOWN_LEFT)) {
                if (this.position.y - moveStep >= 0 && this.position.x - moveStep >= 0
                        && !isHurdle(this.position.x - moveStep, this.position.y - moveStep)) {
                    this.position.y -= moveStep;
                    this.position.x -= moveStep;
                } else {
                    move();
                }
            }
            if (direction.equals(Direction.DOWN_RIGHT)) {
                moveOnAxisY(direction);
            }
        }
    }

    /**
     * Animal's move on axis X, with set direction
     *
     * @param direction set direction
     */
    public void moveOnAxisX(Direction direction) {
        if (direction.equals(Direction.RIGHT)) {
            if (this.position.x + moveStep <= desert.length && !isHurdle(this.position.x + moveStep, this.position.y)) {
                this.position.x += moveStep;
            } else {
                move();
            }
        } else if (direction.equals(Direction.LEFT)) {
            if (this.position.x - moveStep >= 0 && !isHurdle(this.position.x - moveStep, this.position.y)) {
                this.position.x -= moveStep;
            } else {
                move();
            }
        }
    }
}
