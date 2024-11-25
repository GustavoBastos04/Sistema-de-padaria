import { useState } from "react";
import {Table, Button} from "react-bootstrap";
import ItemProduto from "../components/ListItems/ItemProduto.jsx";
import SearchInput from "../components/SearchInput/SearchInput.jsx";
import produtosFakeList from '../static/produtosFakeList.js'

function Produtos() {

    const [currentPage, setCurrentPage] = useState(1)
    const [searchItem, setSearchItem] = useState("")
    const itensPerPage = 10

    const indexOfLastItem = currentPage * itensPerPage
    const indexOfFirstItem = indexOfLastItem - itensPerPage
    
    const filteredItems = produtosFakeList.filter((item) => item.nome.toLowerCase().includes(searchItem))
    const currentItems = filteredItems.slice(indexOfFirstItem, indexOfLastItem)

    const totalPages = Math.ceil(filteredItems.length/itensPerPage)

    const handlePageChange = (pageNumber) => {
        setCurrentPage(pageNumber)
    }

    const handleSearch = (term) => {
        setSearchItem(term.toLowerCase())
        setCurrentPage(1)
    }

    return (
        <div>
            <SearchInput string="nome" onSearch={handleSearch}/>
            <Table className="striped bordered hover">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Valor</th>
                        <th>Quantidade</th>
                        <th className="text-end">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        currentItems.map((item) => {
                            return(
                                <ItemProduto
                                key={item.id} 
                                nome={item.nome} 
                                valor={item.valor}
                                quantidade={item.quantidade}
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

export default Produtos