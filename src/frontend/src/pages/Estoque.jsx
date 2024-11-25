import { useEffect, useState } from "react";
import {Table, Button} from "react-bootstrap";
import ItemEstoque from "../components/ListItems/ItemEstoque.jsx";
import SearchInput from "../components/SearchInputs/SearchInput.jsx";
import { api } from "../services/api.js";

function Estoque() {

    const [stock, setStock] = useState([])

    const [currentPage, setCurrentPage] = useState(1)
    const [searchItem, setSearchItem] = useState("")
    const itensPerPage = 10

    const indexOfLastItem = currentPage * itensPerPage
    const indexOfFirstItem = indexOfLastItem - itensPerPage
    
    const filteredItems = stock.filter((item) => item.nome.toLowerCase().includes(searchItem))
    const currentItems = filteredItems.slice(indexOfFirstItem, indexOfLastItem)

    const totalPages = Math.ceil(filteredItems.length/itensPerPage)

    const handlePageChange = (pageNumber) => {
        setCurrentPage(pageNumber)
    }

    const handleSearch = (term) => {
        setSearchItem(term.toLowerCase())
        setCurrentPage(1)
    }

    async function loadStock() {
        const response = await api.get('estoque-atual-ingrediente')
        console.log(response.data)
        setStock(response.data)
    }

    useEffect(() => {
        loadStock()
    }, [])

    return (
        <div>
            <SearchInput string="nome" onSearch={handleSearch}/>
            <Table className="striped bordered hover">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Quantidade</th>
                        <th>Data de validade</th>
                    </tr>
                </thead>
                <tbody>
                {
                    currentItems.map((item) => {
                            return(
                                <ItemEstoque
                                key={item.id} 
                                nome={item.nome}
                                quantidade={item.quantidade}
                                data_validade={item.data_validade}
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

export default Estoque