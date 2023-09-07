package com.example.demo_project.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.util.CollectionUtils;

import com.example.demo_project.entity.Register;

public class BaseDao {
	@PersistenceContext
	private EntityManager entityManger;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object> params, Class<EntityType> clazz) {// ⊿Τだ掸计
		Query query = entityManger.createQuery(sql, clazz);

//		if (!CollectionUtils.isEmpty(params)) {
//			for (Entry<String, Object> item : params.entrySet()) {
//				query.setParameter(item.getKey(), item.getValue());
//			}
//		}

		// -----
//
		for (Parameter p : query.getParameters()) {
			query.setParameter(p, params.get(p.getName()));
			System.out.println("p" + p);
			System.out.println("p.getName()" + p.getName());
		}

		return query.getResultList();
	}

	// ---
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object> params, Class<EntityType> clazz,
			int pageSize) {// ⊿Τだ掸计
		Query query = entityManger.createQuery(sql, clazz);

		if (!CollectionUtils.isEmpty(params)) {
//			for (Entry<String, Object> item : params.entrySet()) {
//				query.setParameter(item.getKey(), item.getValue());
//			}
			for (Parameter p : query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));
			}
		}
		if (pageSize > 0) {
			query.setMaxResults(pageSize);
		}

		return query.getResultList();
	}

	// ---
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object> params, Class<EntityType> clazz,
			int pageSize, int startPosition) {// ⊿Τだ掸计
		Query query = entityManger.createQuery(sql, clazz);

		if (!CollectionUtils.isEmpty(params)) {
//			for (Entry<String, Object> item : params.entrySet()) {
//				query.setParameter(item.getKey(), item.getValue());
//			}
			for (Parameter p : query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));
			}
		}
		if (pageSize > 0) {
			query.setMaxResults(pageSize);
		}
		if (startPosition >= 0) {
			query.setFirstResult(startPosition);
		}

		return query.getResultList();
	}

	// ---
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <EntityType> List<EntityType> doNativeQuery(String nativeSql, Map<String, Object> params,
			Class<EntityType> clazz, int pageSize, int startPosition) {// ⊿Τだ掸计
//			Query query = entityManger.createQuery(sql, clazz);
		Query query = null;
		if (clazz == null) {
			query = entityManger.createNativeQuery(nativeSql);

		} else {
			query = entityManger.createNativeQuery(nativeSql, clazz);
		}

		if (!CollectionUtils.isEmpty(params)) {
//				for (Entry<String, Object> item : params.entrySet()) {
//					query.setParameter(item.getKey(), item.getValue());
//				}
			for (Parameter p : query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));
			}
		}
		if (pageSize > 0) {
			query.setMaxResults(pageSize);
		}
		if (startPosition >= 0) {
			query.setFirstResult(startPosition);
		}

		return query.getResultList();
	}

	// ---
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected int doQueryUpdateAgeByAccount(String sql, Map<String, Object> params) {// ⊿Τだ掸计
		Query query = entityManger.createQuery(sql);

		if (!CollectionUtils.isEmpty(params)) {
//			for (Entry<String, Object> item : params.entrySet()) {
//				query.setParameter(item.getKey(), item.getValue());
//			}

			// -----

			for (Parameter p : query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));

				System.out.println("p + " + p);
				System.out.println("p.getName() + " + p.getName());
			}
		}
		return query.executeUpdate();
	}

	// ---
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected int doQuery(String sql, Map<String, Object> params) {// ⊿Τだ掸计
		Query query = entityManger.createQuery(sql);

		if (!CollectionUtils.isEmpty(params)) {
//				for (Entry<String, Object> item : params.entrySet()) {
//					query.setParameter(item.getKey(), item.getValue());
//				}

			// -----

			for (Parameter p : query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));
//					System.out.println("query + "+query.getParameter(sql));
				System.out.println("p + " + p);
				System.out.println("p.getName() + " + p.getName());
			}
		}
		return query.executeUpdate();
	}

	// ---
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected int doNativeUpdateByName(String sql, Map<String, Object> params) {// ⊿Τだ掸计
		Query query = entityManger.createNativeQuery(sql);

		if (!CollectionUtils.isEmpty(params)) {
//						for (Entry<String, Object> item : params.entrySet()) {
//							query.setParameter(item.getKey(), item.getValue());
//						}

			// -----

			for (Parameter p : query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));
//							System.out.println("query + "+query.getParameter(sql));
				System.out.println("p + " + p);
				System.out.println("p.getName() + " + p.getName());
			}
		}
		return query.executeUpdate();
	}
	// ---
		@SuppressWarnings({ "unchecked", "rawtypes" })
		protected int doNativeUpdateByAccount(String sql, Map<String, Object> params) {// ⊿Τだ掸计
			Query query = entityManger.createNativeQuery(sql);

			if (!CollectionUtils.isEmpty(params)) {
//							for (Entry<String, Object> item : params.entrySet()) {
//								query.setParameter(item.getKey(), item.getValue());
//							}

				// -----

				for (Parameter p : query.getParameters()) {
					query.setParameter(p, params.get(p.getName()));
//								System.out.println("query + "+query.getParameter(sql));
					System.out.println("p + " + p);
					System.out.println("p.getName() + " + p.getName());
				}
			}
			return query.executeUpdate();
		}

	// -----testDaoよ猭
//	public List<Register> doQueryByExpiredRegTime(Date date) {
//		return null;
//	}

}
