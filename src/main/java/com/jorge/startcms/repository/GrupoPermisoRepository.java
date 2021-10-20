package com.jorge.startcms.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jorge.startcms.model.GrupoPermiso;

@Repository
public class GrupoPermisoRepository implements GrupoPermisoRep {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean save(GrupoPermiso grupoPermiso) {
		
		try {
			String sql = String.format("insert into Grupo_Permiso (IdGrupo,IdPermiso) "
					+ "values ('%d','%d')", 
					grupoPermiso.getIdGrupo(),grupoPermiso.getIdPermiso());
			jdbcTemplate.execute(sql);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean update(GrupoPermiso grupoPermiso) {
		
		if((grupoPermiso.getIdGrupo()) != 0 && grupoPermiso.getIdPermiso() != 0)
		{
			String sql = String.format("update Grupo_Permiso set IdGrupo='%d', IdPermiso='%d' "
					+ "where (IdGrupo='%d' and IdPermiso='%d')", 
					grupoPermiso.getIdGrupo(),grupoPermiso.getIdPermiso(),grupoPermiso.getIdGrupo(),grupoPermiso.getIdPermiso());
			jdbcTemplate.execute(sql);
			return true;
		}
		
		return false;
	}

	@Override
	public List<GrupoPermiso> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GrupoPermiso findBy(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

}
