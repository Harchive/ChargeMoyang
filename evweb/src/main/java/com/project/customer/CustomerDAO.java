package com.project.customer;

import java.util.List;

public interface CustomerDAO {
	// ȸ������
	int register(CustomerDTO dto);
	//ȸ����Ϻ���
	List<CustomerDTO> customerList();
	//ȸ�� ����
	int update(CustomerDTO dto);
	//ȸ�� ����
	int delete(String customer_id);
	//id �ߺ� üũ
	boolean idCheck(String customer_id);
	//mypage���� ȸ������ ��ȸ
	public CustomerDTO getCustomerInfo(String customer_id);
	
}
