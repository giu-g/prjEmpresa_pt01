package com.giuliag.PrjEmpresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giuliag.PrjEmpresa.entities.Funcionario;
import com.giuliag.PrjEmpresa.services.FuncionarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Funcionario", description = "Controle de funcionários")
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	private final FuncionarioService funcionarioService;
	
	@Autowired
	public FuncionarioController (FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
	
	@PostMapping
	@Operation(summary = "Cadastra um funcionário")
	public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioService.saveFuncionario(funcionario);
	}
	
	@GetMapping("/{funCodigo}")
	@Operation(summary = "Apresenta todos os funcionários")
	public Funcionario getFuncionario(@PathVariable Long funCodigo) {
		return funcionarioService.getFuncionarioById(funCodigo);
	}
	
	@GetMapping
	public List<Funcionario> getAllFuncionario() {
		return funcionarioService.getAllFuncionario();
	}
	
	@DeleteMapping("/{funCodigo}")
	@Operation(summary = "Exclui um usuário")
	public void deleteFuncionario(@PathVariable Long funCodigo) {
		funcionarioService.deleteFuncionario(funCodigo);
	}

}
