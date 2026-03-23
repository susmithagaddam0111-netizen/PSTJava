class ParkingSystem {
    private int bigSlots;
    private int mediumSlots;
    private int smallSlots;

    public ParkingSystem(int big, int medium, int small) {
        this.bigSlots = big;
        this.mediumSlots = medium;
        this.smallSlots = small;
    }
    
    public boolean addCar(int carType) {
        switch(carType) {
            case 1: // big car
                if (bigSlots > 0) {
                    bigSlots--;
                    return true;
                }
                return false;
            case 2: // medium car
                if (mediumSlots > 0) {
                    mediumSlots--;
                    return true;
                }
                return false;
            case 3: // small car
                if (smallSlots > 0) {
                    smallSlots--;
                    return true;
                }
                return false;
            default:
                return false; // invalid car type
        }
    }
}
