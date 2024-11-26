import PropTypes from 'prop-types'
import { Modal, Card } from 'react-bootstrap'
import { api } from '../../services/api'
import { useLayoutEffect, useState } from 'react'

function ProfitModal({ show, onClose, productID }) {
    const [info, setInfo] = useState(null)

    async function loadInfo() {
        const response = await api.get('lucro-por-produto')
        if (Array.isArray(response.data)) {
            const item = response.data.find((item) => item.id_produto == productID)
            if (item) {
                setInfo(item)
                console.log(item)
            }
        }
    }

    useLayoutEffect(() => {
        if (show && productID) {
            loadInfo()
        }
    }, [show, productID])

    const formatCurrency = (value) => {
        const formattedValue = Math.abs(value).toFixed(2).replace('.', ',');
        return value < 0 ? `- R$${formattedValue}` : `R$${formattedValue}`;
    }

    return (
        <div>
            <Modal show={show} fullscreen={true} onHide={onClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Lucro do produto {info?.nome}</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Card className={`shadow mb-4 ${info?.receita >= 0 ? 'bg-success' : 'bg-danger'}`}>
                        <Card.Body>
                            <Card.Title className="text-center text-white font-weight-bold">Receita gerada até o momento</Card.Title>
                            <Card.Text className="text-center text-white">{formatCurrency(info?.receita || 0)}</Card.Text>
                        </Card.Body>
                    </Card>
                    <Card className={`shadow mb-4 ${(info?.custo - info?.receita) < 0 ? 'bg-success' : 'bg-danger'}`}>
                        <Card.Body>
                            <Card.Title className="text-center text-white font-weight-bold">Custo total do produto</Card.Title>
                            <Card.Text className="text-center text-white">{formatCurrency(info?.custo || 0)}</Card.Text>
                        </Card.Body>
                    </Card>
                    <Card className={`shadow mb-4 ${info?.lucro >= 0 ? 'bg-success' : 'bg-danger'}`}>
                        <Card.Body>
                            <Card.Title className="text-center text-white font-weight-bold">Lucro estimado para o produto</Card.Title>
                            <Card.Text className="text-center text-white">{formatCurrency(info?.lucro || 0)}</Card.Text>
                        </Card.Body>
                    </Card>
                </Modal.Body>
            </Modal>
        </div>
    )
}

ProfitModal.propTypes = {
    show: PropTypes.bool.isRequired,
    onClose: PropTypes.func.isRequired,
    productID: PropTypes.number.isRequired,
}

export default ProfitModal
