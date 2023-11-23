package com.giuliag.PrjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giuliag.PrjEmpresa.entities.Funcionario;
import com.giuliag.PrjEmpresa.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

	private final FuncionarioRepository funcionarioRepository;

	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;

	}

	public Funcionario saveFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public List<Funcionario> getAllFuncionario() {
		return funcionarioRepository.findAll();
	}

	public Funcionario getFuncionarioById(Long funCodigo) {
		return funcionarioRepository.findById(funCodigo).orElse(null);
	}

	public void deleteFuncionario(Long funCodigo) {
		funcionarioRepository.deleteById(funCodigo);
	}

	public Funcionario updateFuncionario(Long funCodigo, Funcionario novoFuncionario) {
		Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(funCodigo);
		if (funcionarioOptional.isPresent()) {
			Funcionario funcionarioExistente = funcionarioOptional.get();
			funcionarioExistente.setFunNome(novoFuncionario.getFunNome());
			funcionarioExistente.setFunCodigo(novoFuncionario.getFunCodigo());
			return funcionarioRepository.save(funcionarioExistente);
		} else {
			return null;
		}
	}

}
