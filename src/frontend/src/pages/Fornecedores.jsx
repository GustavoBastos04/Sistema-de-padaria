import React from "react"
import { useEffect, useState } from "react";
import {Table, Button} from "react-bootstrap";
import ItemFornecedor from "../components/ListItems/ItemFornecedor.jsx";
import SearchInput from "../components/SearchInputs/SearchInput.jsx";
import { api } from "../services/api.js";

function Fornecedores() {

    const [suppliers, setSupliers] = useState([])

    const [currentPage, setCurrentPage] = useState(1)
    const [searchItem, setSearchItem] = useState("")
    const itensPerPage = 10

    const indexOfLastItem = currentPage * itensPerPage
    const indexOfFirstItem = indexOfLastItem - itensPerPage
    
    const filteredItems = suppliers.filter((item) => item.nome.toLowerCase().includes(searchItem))
    const currentItems = filteredItems.slice(indexOfFirstItem, indexOfLastItem)

    const totalPages = Math.ceil(filteredItems.length/itensPerPage)

    const handlePageChange = (pageNumber) => {
        setCurrentPage(pageNumber)
    }

    const handleSearch = (term) => {
        setSearchItem(term.toLowerCase())
        setCurrentPage(1)
    }
    
    async function loadSuppliers() {
        const response = await api.get('fornecedor')
        console.log(response.data)
        setSupliers(response.data)
    }

    useEffect(() => {
        loadSuppliers()
    }, [])

    return (
        <div>
            <SearchInput string="nome do fornecedor" onSearch={handleSearch}/>
            <Table>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>CNPJ</th>
                        <th>Telefone</th>
                        <th>Email</th>
                        <th>CEP</th>
                    </tr>
                </thead>
                <tbody>
                {
                    currentItems.map((item) => {
                            return(
                                <ItemFornecedor
                                key={item.id} 
                                nome={item.nome}
                                cnpj={item.cnpj}
                                tel={item.telefone}
                                email={item.email}
                                cep={item.cep}
                                flag={1}
                                />
                            )
                        })
                    }
                </tbody>
            </Table>
            <div className="pagination d-flex justify-content-center align-itens-center">
                    {Array.from({length: totalPages}, (_, index) => (
                        <Button
                        key={index+1}
                        onClick={() => handlePageChange(index+1)}
                        variant={currentPage === index + 1 ? "primary" : "outline-primary"}
                        className="m-1"
                        >
                            {index+1}
                        </Button>
                    ))}
            </div>
        </div>
    )
}

export default Fornecedores