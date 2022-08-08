package com.duing.login.dnamic;

import com.duing.login.domain.F_user_address;

public class AddressDnamic {

    public String provideSql(F_user_address address, Integer userId) {
        StringBuffer sb = new StringBuffer();
        sb.append("insert into f_user_address(");
        if (address.getAddressName() != null && address.getAddressName() != "") {
            sb.append("address_name");
        }
        if (address.getAddressPhone() != null && address.getAddressPhone() != "") {
            sb.append(",address_phone");
        }
        if (address.getAddressProvince() != null && address.getAddressProvince() != "") {
            sb.append(",address_province");
        }
        if (address.getAddressCity() != null && address.getAddressCity() != "") {
            sb.append(",address_city");
        }
        if (address.getAddressCounty() != null && address.getAddressCounty() != "") {
            sb.append(",address_county");
        }
        if (address.getAddressDetail() != null && address.getAddressDetail() != "") {
            sb.append(",address_detail");
        }
        if (address.getAddressZipCode() != null && address.getAddressZipCode() != 0) {
            sb.append(",address_zip_code");
        }

        sb.append(") values(");

        if (address.getAddressName() != null && address.getAddressName() != "") {
            sb.append("#{addressName}");
        }
        if (address.getAddressPhone() != null && address.getAddressPhone() != "") {
            sb.append(",#{addressPhone}");
        }
        if (address.getAddressProvince() != null && address.getAddressProvince() != "") {
            sb.append(",#{addressProvince}");
        }
        if (address.getAddressCity() != null && address.getAddressCity() != "") {
            sb.append(",#{addressCity}");
        }
        if (address.getAddressCounty() != null && address.getAddressCounty() != "") {
            sb.append(",#{addressCounty}");
        }
        if (address.getAddressDetail() != null && address.getAddressDetail() != "") {
            sb.append(",#{addressDetail}");
        }
        if (address.getAddressZipCode() != null && address.getAddressZipCode() != 0) {
            sb.append(",#{addressZipCode}");
        }
        sb.append(")");
        System.out.println(sb);
        return sb.toString();
    }
}
