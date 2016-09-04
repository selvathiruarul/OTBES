package com.otbes.service;

import java.sql.SQLException;

import com.otbes.dao.BTHMDAO;
import com.otbes.vo.BTHMChangePwdVO;

public class BTHMChangePwdService {

	public int changePassword(BTHMChangePwdVO cpwdvo) throws SQLException {
		BTHMDAO dao = new BTHMDAO();
		int count = dao.updatePassword(cpwdvo);
		return count;

	}

}
