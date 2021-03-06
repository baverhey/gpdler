package net.straininfo2.grs.idloader.bioproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrganismEnvironment {

    public enum Salinity {
        eUnknown,
        eNonHalophilic,
        eMesophilic,
        eModerateHalophilic,
        eExtremeHalophilic
    }
    
    public enum OxygenReq {
        eUnknown,
        eAerobic,
        eMicroaerophilic,
        eFacultative,
        eAnaerobic
    }

    public enum TemperatureRange {
        eUnknown,
        eCryophilic,
        ePsychrophilic,
        eMesophilic,
        eThermophilic,
        eHyperthermophilic
    }
    
    public enum Habitat {
        eUnknown,
        eHostAssociated,
        eAquatic,
        eTerrestrial,
        eSpecialized,
        eMultiple
    }

    private long id;
    
    private Salinity salinity;
    
    private OxygenReq oxygenReq;
    
    private String optimumTemperature;
    
    private TemperatureRange temperatureRange;
    
    private Habitat habitat;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Salinity getSalinity() {
        return salinity;
    }

    public void setSalinity(Salinity salinity) {
        this.salinity = salinity;
    }

    public OxygenReq getOxygenReq() {
        return oxygenReq;
    }

    public void setOxygenReq(OxygenReq oxygenReq) {
        this.oxygenReq = oxygenReq;
    }

    public String getOptimumTemperature() {
        return optimumTemperature;
    }

    public void setOptimumTemperature(String optimumTemperature) {
        this.optimumTemperature = optimumTemperature;
    }

    public TemperatureRange getTemperatureRange() {
        return temperatureRange;
    }

    public void setTemperatureRange(TemperatureRange temperatureRange) {
        this.temperatureRange = temperatureRange;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }
}
