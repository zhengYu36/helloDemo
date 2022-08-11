package com.example.demo.entry.influxdb;
 
import lombok.Data;
import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;
import plus.ojbk.influxdb.annotation.Count;
 
import java.math.BigDecimal;
import java.time.LocalDateTime;
 
/**
 * @author wxm
 * @version 1.0
 * @since 2021/6/17 18:26
 *
 * 瞎编的设备模型
 *
 */
@Data
@Measurement(name = "device")
public class Device {
    /**
     * 设备编号
     */
    @Column(name="device_no", tag = true)  //tag 可以理解为influxdb的索引
    private String deviceNo;
    /**
     * 数据值
     */
    @Count("value")
    @Column(name="value")
    private BigDecimal value;
    /**
     * 电压
     */
    @Column(name="voltage")
    private Float voltage;
    /**
     * 状态
     */
    @Column(name="state")
    private Boolean state;
    /**
     * 上报时间
     */
    @Column(name="time")
    private LocalDateTime time;
 
}