package kasei.spring.transaction.b02anno.impl;

import kasei.spring.transaction.b02anno.B01SellerDao;
import kasei.spring.transaction.b02anno.RepositoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("b01SellerDao")
public class B01SellerDaoImpl implements B01SellerDao {
	
	/** 该类对用于操作数据库中的 seller 表
	 * create table springdemo_seller(
	 * 		goodname varchar(20) primary key, -- 获取的名称
	 *      repository int(6)	  -- 表示当前货物的库存数量
	 * );
	 * */
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	// 出货
	public void deliverAA() throws RepositoryException {
		String sql2 = "select repository from springdemo_seller where goodname='AA'";
		int stock = jdbcTemplate.queryForObject(sql2, Integer.class);
		if(stock < 10) {
			throw new RepositoryException("库存不足");
		}
		
		String sql = "update springdemo_seller set repository=repository-10 where goodname='AA'";
		jdbcTemplate.update(sql);		
	}
	
	public void deliverBB() throws RepositoryException {
		String sql2 = "select repository from springdemo_seller where goodname='BB'";
		int stock = jdbcTemplate.queryForObject(sql2, Integer.class);
		if(stock < 10) {
			throw new RepositoryException("库存不足");
		}
		
		String sql = "update springdemo_seller set repository=repository-10 where goodname='AA'";
		jdbcTemplate.update(sql);		
	}
}
