package pl.transport.transportapp.model.currency;

public class Rate {
    private String no;
    private String effectiveDate;
    private double mid;



    public String getNo() { return this.no; }

    public void setNo(String no) { this.no = no; }

    public String getEffectiveDate() { return this.effectiveDate; }

    public void setEffectiveDate(String effectiveDate) { this.effectiveDate = effectiveDate; }

    public double getMid() { return this.mid; }

    public void setMid(double mid) { this.mid = mid; }
}
