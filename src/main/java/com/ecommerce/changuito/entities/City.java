package com.ecommerce.changuito.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.*;

@Getter
@Setter
@Entity

@Table(name="city")
@SQLDelete(sql = "UPDATE city SET deleted = true WHERE id_city=?")
@Where(clause = "deleted=false")

public class City extends BaseEntity{

   /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_city")
    private  Long id; */

    public enum CityEnum {
        ADOLFO_ALSINA(1), AGUA_DE_ORO(2), AMERICA(3), BAHIA_BLANCA(4), BARILOCHE(5), CAPITAL_FEDERAL(6), EZEIZA(7), FORMOSA(8), JUNIN(9), LA_MATANZA(10);

        private final Integer value;

        private CityEnum(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public static CityEnum parse(Integer id) {
            CityEnum status = null; // Default
            for (CityEnum item : CityEnum.values()) {
                if (item.getValue().equals(id)) {
                    status = item;
                    break;
                }
            }
            return status;
        }
    }
}
