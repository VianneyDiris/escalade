package org.escalade.demo.consumer.impl.dao.topo;

import java.util.List;

import org.escalade.demo.consumer.contract.dao.topo.TopoDao;
import org.escalade.demo.consumer.impl.dao.AbstractDaoImpl;
import org.escalade.demo.consumer.impl.rowmapper.topo.TopoRM;
import org.escalade.demo.model.bean.spot.Spot;
import org.escalade.demo.model.bean.topo.Topo;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao {

	@Override
	public List<Topo> listTopo() {
		// TODO Auto-generated method stub
		String vsql = "SELECT * FROM public.topo where id>1";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		TopoRM rowTopo = new TopoRM();
		
		List<Topo> listTopos = vJdbcTemplate.query(vsql, rowTopo);
		return listTopos;
	}

	@Override
	public void addTopo(Topo topo) {
		// TODO Auto-generated method stub
		String vsql = "INSERT INTO public.topo (nom,description,photo,prive,reserve,spot_id) VALUES (?,?,?,?,?,?)";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		vJdbcTemplate.update(vsql,topo.getNom(),topo.getDescription(),topo.getPhoto(),topo.isPrive(),topo.isReserve(),topo.getSpot().getId());
		
	}

	@Override
	public void updateTopo(Topo topo) {
		// TODO Auto-generated method stub
		String vSQL = "UPDATE public.topo SET nom =?, description=?,prive=?,reserve=?,spot_id=? WHERE id = ?";
		 
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
	    vJdbcTemplate.update(vSQL,topo.getNom(),topo.getDescription(),topo.isPrive(),topo.isReserve(),topo.getSpot().getId(),topo.getId());
		
	}

	@Override
	public void deleteTopo(Integer id) {
		// TODO Auto-generated method stub
		String vsql="DELETE FROM public.topo WHERE id=?";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		vJdbcTemplate.update(vsql,new Object[] { id });
		
	}

	@Override
	public Topo find(Integer id) {
		// TODO Auto-generated method stub
		String vsql ="SELECT * FROM public.topo WHERE id= ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		Topo topo=(Topo)vJdbcTemplate.queryForObject(vsql, new Object[] { id }, new TopoRM());
		
		return topo;
	}

	@Override
	public Topo getTopoBySpot(Spot spot) {
		// TODO Auto-generated method stub
		String vsql ="SELECT * FROM public.topo WHERE spot_id= ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		Topo topo = new Topo();
		try {
		topo=(Topo)vJdbcTemplate.queryForObject(vsql, new Object[] { spot.getId() }, new TopoRM());
		}
		catch(EmptyResultDataAccessException e) {
			return null;
		}
		
		
		return topo;
	}

	@Override
	public List<Topo> listTopoBySpot(Spot spot) {
		String vsql = "SELECT * FROM public.topo WHERE spot_id=?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		TopoRM rowTopo = new TopoRM();
		
		List<Topo> listTopos = vJdbcTemplate.query(vsql,new Object[] { spot.getId() }, rowTopo);
		
		return listTopos;
	}



}
