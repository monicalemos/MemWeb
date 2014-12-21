package pt.memplus.web.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pt.memplus.web.daos.AddressDAO;
import pt.memplus.web.models.Address;

@Service("AddressService")
@Transactional
public class AddressServiceImpl implements AddressService {
	@Autowired
    private AddressDAO dao;
	
	@Override
	public void save(Address address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Address address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Address> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
