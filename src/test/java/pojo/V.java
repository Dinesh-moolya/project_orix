
package pojo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@Jacksonized
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class V {

    @JsonProperty("timestamp")
    public Long timestamp;
    @JsonProperty("v_id")
    public String vId;
    @JsonProperty("id")
    public String id;
    @JsonProperty("last_msg_t")
    public Long lastMsgT;
    @JsonProperty("protocol")
    public String protocol;
    @JsonProperty("spec_id")
    public String specId;
    @JsonProperty("last_state")
    public LastState lastState;
    @JsonProperty("ad_blue")
    public AdBlue adBlue;
    @JsonProperty("is_adblue")
    public Boolean isAdblue;
    @JsonProperty("health_vehicle_id")
    public Object healthVehicleId;
    @JsonProperty("location_vehicle_id")
    public Object locationVehicleId;
    @JsonProperty("fuel_vehicle_id")
    public Object fuelVehicleId;
    @JsonProperty("fuel_vehicle_account_id")
    public Object fuelVehicleAccountId;
    @JsonProperty("def_vehicle_id")
    public Object defVehicleId;
    @JsonProperty("def_vehicle_account_id")
    public Object defVehicleAccountId;
    @JsonProperty("demo_vehicle")
    public Object demoVehicle;
    @JsonProperty("last_obd")
    public Long lastObd;
    @JsonProperty("last_obd_data_time")
    public Long lastObdDataTime;
    @JsonProperty("connection_status")
    public ConnectionStatus connectionStatus;
    @JsonProperty("def_page_enabled")
    public DefPageEnabled defPageEnabled;
    @JsonProperty("location_page_enabled")
    public LocationPageEnabled locationPageEnabled;
    @JsonProperty("health_page_enabled")
    public HealthPageEnabled healthPageEnabled;
    @JsonProperty("fuel_page_enabled")
    public FuelPageEnabled fuelPageEnabled;
    @JsonProperty("is_enabled")
    public Boolean isEnabled;
    @JsonProperty("subscription")
    public Subscription subscription;
    @JsonProperty("account")
    public String account;
    @JsonProperty("account_id")
    public String accountId;
    @JsonProperty("plate")
    public String plate;
    @JsonProperty("tag")
    public String tag;
    @JsonProperty("tagged")
    public String tagged;
    @JsonProperty("is_obd")
    public Boolean isObd;
    @JsonProperty("obd_attached")
    public Boolean obdAttached;
    @JsonProperty("obd")
    public Boolean obd;
    @JsonProperty("fuel_enabled")
    public Boolean fuelEnabled;
    @JsonProperty("fuel_level_enabled")
    public Boolean fuelLevelEnabled;
    @JsonProperty("is_fuel")
    public Boolean isFuel;
    @JsonProperty("location")
    public List<String> location;
    @JsonProperty("status_object")
    public StatusObject statusObject;
    @JsonProperty("status")
    public String status;
    @JsonProperty("health_info")
    public HealthInfo healthInfo;
    @JsonProperty("health")
    public Integer health;
    @JsonProperty("dtcs_new")
    public List<DtcsNew> dtcsNew;
    @JsonProperty("dtcs")
    public Dtcs dtcs;
    @JsonProperty("t_id")
    public String tId;
    @JsonProperty("t_imei")
    public String tImei;
    @JsonProperty("idevice")
    public Idevice idevice;
    @JsonProperty("geofence")
    public Geofence geofence;
    @JsonProperty("odom")
    public Odom odom;
    @JsonProperty("engine_info")
    public EngineInfo engineInfo;
    @JsonProperty("tags")
    public List<String> tags;
    @JsonProperty("connector_attached_flag")
    public Boolean connectorAttachedFlag;
    @JsonProperty("cluster_id")
    public String clusterId;
    @JsonProperty("fuel")
    public Fuel fuel;
    @JsonProperty("fuel_info")
    public FuelInfo fuelInfo;
    @JsonProperty("mobileye_enabled")
    public boolean mobileyeEnabled;
    @JsonProperty("is_fuel_level_low")
    public boolean isFuelLevelLow;
    @JsonProperty("is_ad_blue_level_low")
    public boolean isAdBlueLevelLow;

    /**
     * No args constructor for use in serialization
     *
     */
    public V() {
    }

    /**
     *
     * @param connectorAttachedFlag
     * @param dtcsNew
     * @param healthVehicleId
     * @param protocol
     * @param tagged
     * @param isObd
     * @param id
     * @param fuelVehicleId
     * @param tag
     * @param fuelVehicleAccountId
     * @param specId
     * @param isFuel
     * @param isAdblue
     * @param geofence
     * @param idevice
     * @param lastMsgT
     * @param locationPageEnabled
     * @param tId
     * @param dtcs
     * @param tags
     * @param vId
     * @param accountId
     * @param fuelLevelEnabled
     * @param isEnabled
     * @param connectionStatus
     * @param adBlue
     * @param healthInfo
     * @param status
     * @param odom
     * @param lastObd
     * @param plate
     * @param clusterId
     * @param lastState
     * @param obdAttached
     * @param statusObject
     * @param tImei
     * @param locationVehicleId
     * @param fuelEnabled
     * @param timestamp
     * @param engineInfo
     * @param defPageEnabled
     * @param defVehicleAccountId
     * @param health
     * @param lastObdDataTime
     * @param obd
     * @param defVehicleId
     * @param healthPageEnabled
     * @param demoVehicle
     * @param location
     * @param fuelPageEnabled
     * @param account
     * @param subscription
     * @param mobileyeEnabled
     * @param fuel
     * @param fuelInfo
     * @param isAdBlueLevelLow
     * @param isFuelLevelLow
     */
    public V(Long timestamp, String vId, String id, Long lastMsgT, String protocol, String specId, LastState lastState,
            AdBlue adBlue, Boolean isAdblue, Object healthVehicleId, Object locationVehicleId, Object fuelVehicleId,
            Object fuelVehicleAccountId, Object defVehicleId, Object defVehicleAccountId, Object demoVehicle,
            Long lastObd, Long lastObdDataTime, ConnectionStatus connectionStatus, DefPageEnabled defPageEnabled,
            LocationPageEnabled locationPageEnabled, HealthPageEnabled healthPageEnabled,
            FuelPageEnabled fuelPageEnabled, Boolean isEnabled, Subscription subscription, String account,
            String accountId, String plate, String tag, String tagged, Boolean isObd, Boolean obdAttached, Boolean obd,
            Boolean fuelEnabled, Boolean fuelLevelEnabled, Boolean isFuel, List<String> location,
            StatusObject statusObject, String status, HealthInfo healthInfo, Integer health, List<DtcsNew> dtcsNew,
            Dtcs dtcs, String tId, String tImei, Idevice idevice, Geofence geofence, Odom odom, EngineInfo engineInfo,
            List<String> tags, Boolean connectorAttachedFlag, String clusterId, Fuel fuel, FuelInfo fuelInfo,
            boolean mobileyeEnabled, boolean isFuelLevelLow, boolean isAdBlueLevelLow) {
        super();
        this.timestamp = timestamp;
        this.vId = vId;
        this.id = id;
        this.lastMsgT = lastMsgT;
        this.protocol = protocol;
        this.specId = specId;
        this.lastState = lastState;
        this.adBlue = adBlue;
        this.isAdblue = isAdblue;
        this.healthVehicleId = healthVehicleId;
        this.locationVehicleId = locationVehicleId;
        this.fuelVehicleId = fuelVehicleId;
        this.fuelVehicleAccountId = fuelVehicleAccountId;
        this.defVehicleId = defVehicleId;
        this.defVehicleAccountId = defVehicleAccountId;
        this.demoVehicle = demoVehicle;
        this.lastObd = lastObd;
        this.lastObdDataTime = lastObdDataTime;
        this.connectionStatus = connectionStatus;
        this.defPageEnabled = defPageEnabled;
        this.locationPageEnabled = locationPageEnabled;
        this.healthPageEnabled = healthPageEnabled;
        this.fuelPageEnabled = fuelPageEnabled;
        this.isEnabled = isEnabled;
        this.subscription = subscription;
        this.account = account;
        this.accountId = accountId;
        this.plate = plate;
        this.tag = tag;
        this.tagged = tagged;
        this.isObd = isObd;
        this.obdAttached = obdAttached;
        this.obd = obd;
        this.fuelEnabled = fuelEnabled;
        this.fuelLevelEnabled = fuelLevelEnabled;
        this.isFuel = isFuel;
        this.location = location;
        this.statusObject = statusObject;
        this.status = status;
        this.healthInfo = healthInfo;
        this.health = health;
        this.dtcsNew = dtcsNew;
        this.dtcs = dtcs;
        this.tId = tId;
        this.tImei = tImei;
        this.idevice = idevice;
        this.geofence = geofence;
        this.odom = odom;
        this.engineInfo = engineInfo;
        this.tags = tags;
        this.connectorAttachedFlag = connectorAttachedFlag;
        this.clusterId = clusterId;
        this.fuel = fuel;
        this.fuelInfo = fuelInfo;
        this.mobileyeEnabled = mobileyeEnabled;
        this.isFuelLevelLow = isFuelLevelLow;
        this.isAdBlueLevelLow = isAdBlueLevelLow;
    }

}
