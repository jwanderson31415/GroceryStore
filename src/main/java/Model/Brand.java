package Model;

public class Brand extends Inventory {
    private int brandItemId;
    private String brandName;

    public Brand (int brandItemId, String brandName) {
        this.brandItemId = brandItemId;
        this.brandName = brandName;
    }

    public int getBrandItemId() {
        return brandItemId;
    }

    public void setBrandItemId(int brandItemId) {
        this.brandItemId = brandItemId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandItemId=" + brandItemId +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
