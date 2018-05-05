package excelApp.ghost.gvv;

public class Cable
{
    public Cable(String cableLength,
                 String cableDesignation,
                 String startPoint,
                 String endPoint,
                 String cableBrand,
                 String numberAndSelectionsOfCores)
    {
        this.cableLength = cableLength;
        this.cableDesignation = cableDesignation;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.cableBrand = cableBrand;
        this.numberAndSelectionsOfCores = numberAndSelectionsOfCores;
    }

    public String getCableLength() {
        return cableLength;
    }

    public String getCableBrand() {
        return cableBrand;
    }

    public String getCableDesignation() {
        return cableDesignation;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getNumberAndSelectionsOfCores() {
        return numberAndSelectionsOfCores;
    }

    public void setCableBrand(String cableBrand) {
        this.cableBrand = cableBrand;
    }

    public void setCableDesignation(String cableDesignation) {
        this.cableDesignation = cableDesignation;
    }

    public void setCableLength(String cableLength) {
        this.cableLength = cableLength;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public void setNumberAndSelectionsOfCores(String numberAndSelectionsOfCores) {
        this.numberAndSelectionsOfCores = numberAndSelectionsOfCores;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    private String cableLength;
    private String cableDesignation;
    private String startPoint;
    private String endPoint;
    private String cableBrand;
    private String numberAndSelectionsOfCores;
}
