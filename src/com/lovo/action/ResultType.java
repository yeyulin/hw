package com.lovo.action;

/**
 * Actionִ�н������
 * @author Ҷ����
 *
 */
public enum ResultType {
	/**
	 * �ض���
	 */
	Redirect, 
	/**
	 * ת��
	 */
	Forward, 
	/**
	 * �첽����
	 */
	Ajax,
	/**
	 * ������
	 */
	Stream,
	/**
	 * ��ת������һ��������
	 */
	Chain,
	/**
	 * �ض�����һ��������
	 */
	RedirectChain
}
