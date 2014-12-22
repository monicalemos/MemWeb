package pt.memplus.web.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pt.memplus.web.daos.AddressDAO;
import pt.memplus.web.models.Address;

@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService {
	@Autowired
    private AddressDAO dao;
	
	@Override
	public void save(Address address) {
		dao.save(address);
		
	}

	@Override
	public void update(Address address) {
		dao.update(address);
		
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
		
	}

	@Override
	public Iterable<Address> getAll() {
		return dao.getAll();
	}

	@Override
	public Address getById(int id) {
		return dao.getById(id);
	}


}
