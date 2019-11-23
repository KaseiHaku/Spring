package kasei.spring.transaction.b02anno.impl;

import kasei.spring.transaction.b02anno.B02BuyerDao;
import kasei.spring.transaction.b02anno.UserMoneyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("b02BuyerDao")
public class B02BuyerDaoImpl implements B02BuyerDao {

	/** 该类对用于操作数据库中的 buyer 表
	 * create table springdemo_buyer(
	 * 		name varchar(20) primary key, -- 买主的姓名
	 *      money int(6)  -- 表示买主拥有的钱
	 * );
	 * */
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 付钱
	public void payMoney() throws UserMoneyException {
		String sql2 = "select money from springdemo_buyer where name='kasei'";
		int balance = jdbcTemplate.queryForObject(sql2, Integer.class);
		if(balance < 10) {
			throw new UserMoneyException("余额不足！");
		}
		
		String sql = "update springdemo_buyer set money=money-10 where name='kasei'";
		jdbcTemplate.update(sql);			
	}	
}
