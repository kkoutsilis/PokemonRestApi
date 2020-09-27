package com.example.PokemonDB.service;

import com.example.PokemonDB.dao.PokemonDao;
import com.example.PokemonDB.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PokemonService {

    private final PokemonDao pokemonDao;
    @Autowired
    public PokemonService(@Qualifier("fakeDao") PokemonDao pokemonDao){
        this.pokemonDao=pokemonDao;
    }

    public int addPokemon(Pokemon pokemon){
        return pokemonDao.insertPokemon(pokemon);
    }

    public List<Pokemon> getAllPokemon(){
        return pokemonDao.selectAllPokemon();
    }

    public Optional<Pokemon> getPokemonById(UUID id){
        return pokemonDao.selectPokemonById(id);
    }

    public int deletePokemonById(UUID id){
        return pokemonDao.deletePokemonById(id);
    }

    public int updatePokemonById(UUID id,Pokemon newPokemon){
        return pokemonDao.updatePokemonById(id,newPokemon);
    }
}
