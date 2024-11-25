import { useState } from "react";
import {Table, Button} from "react-bootstrap"
import ItemPagamento from "../../components/ListItems/ItemPagamento.jsx";
import SearchInput from "../../components/SearchInput/SearchInput.jsx";
import pagamentosFakeList from '../../static/pagamentosFakeList.js'

function HistoricoPagamentos() {

    const [currentPage, setCurrentPage] = useState(1)
    const [searchItem, setSearchItem] = useState("")
    const itensPerPage = 10

    const indexOfLastItem = currentPage * itensPerPage
    const indexOfFirstItem = indexOfLastItem - itensPerPage
    
    const filteredItems = pagamentosFakeList.filter((item) => item.forma.toLowerCase().includes(searchItem))
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
            <SearchInput string="forma de pagamento" onSearch={handleSearch}/>
            <Table className="striped bordered hover">
                <thead>
                    <tr>
                        <th>CPF do cliente</th>
                        <th>Forma de pagamento</th>
                    </tr>
                </thead>
                <tbody>
                {
                    currentItems.map((item) => {
                            return(
                                <ItemPagamento
                                key={item.id} 
                                cpf_cliente={item.cpf_cliente}
                                forma={item.forma}
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

export default HistoricoPagamentos